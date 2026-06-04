/*
 * Copyright 2026 Google LLC
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

package com.google.devicesandservices.health.v4.stub;

import static com.google.devicesandservices.health.v4.DataSubscriptionServiceClient.ListSubscribersPagedResponse;
import static com.google.devicesandservices.health.v4.DataSubscriptionServiceClient.ListSubscriptionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.devicesandservices.health.v4.CreateSubscriberMetadata;
import com.google.devicesandservices.health.v4.CreateSubscriberRequest;
import com.google.devicesandservices.health.v4.CreateSubscriptionRequest;
import com.google.devicesandservices.health.v4.DeleteSubscriberMetadata;
import com.google.devicesandservices.health.v4.DeleteSubscriberRequest;
import com.google.devicesandservices.health.v4.DeleteSubscriptionRequest;
import com.google.devicesandservices.health.v4.ListSubscribersRequest;
import com.google.devicesandservices.health.v4.ListSubscribersResponse;
import com.google.devicesandservices.health.v4.ListSubscriptionsRequest;
import com.google.devicesandservices.health.v4.ListSubscriptionsResponse;
import com.google.devicesandservices.health.v4.Subscriber;
import com.google.devicesandservices.health.v4.Subscription;
import com.google.devicesandservices.health.v4.UpdateSubscriberMetadata;
import com.google.devicesandservices.health.v4.UpdateSubscriberRequest;
import com.google.devicesandservices.health.v4.UpdateSubscriptionRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataSubscriptionServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (health.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createSubscription:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataSubscriptionServiceStubSettings.Builder dataSubscriptionServiceSettingsBuilder =
 *     DataSubscriptionServiceStubSettings.newBuilder();
 * dataSubscriptionServiceSettingsBuilder
 *     .createSubscriptionSettings()
 *     .setRetrySettings(
 *         dataSubscriptionServiceSettingsBuilder
 *             .createSubscriptionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * DataSubscriptionServiceStubSettings dataSubscriptionServiceSettings =
 *     dataSubscriptionServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createSubscriber:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataSubscriptionServiceStubSettings.Builder dataSubscriptionServiceSettingsBuilder =
 *     DataSubscriptionServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataSubscriptionServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class DataSubscriptionServiceStubSettings
    extends StubSettings<DataSubscriptionServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateSubscriberRequest, Operation> createSubscriberSettings;
  private final OperationCallSettings<CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
      createSubscriberOperationSettings;
  private final PagedCallSettings<
          ListSubscribersRequest, ListSubscribersResponse, ListSubscribersPagedResponse>
      listSubscribersSettings;
  private final UnaryCallSettings<UpdateSubscriberRequest, Operation> updateSubscriberSettings;
  private final OperationCallSettings<UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
      updateSubscriberOperationSettings;
  private final UnaryCallSettings<DeleteSubscriberRequest, Operation> deleteSubscriberSettings;
  private final OperationCallSettings<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
      deleteSubscriberOperationSettings;
  private final UnaryCallSettings<CreateSubscriptionRequest, Subscription>
      createSubscriptionSettings;
  private final PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings;
  private final UnaryCallSettings<UpdateSubscriptionRequest, Subscription>
      updateSubscriptionSettings;
  private final UnaryCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings;

  private static final PagedListDescriptor<
          ListSubscribersRequest, ListSubscribersResponse, Subscriber>
      LIST_SUBSCRIBERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSubscribersRequest, ListSubscribersResponse, Subscriber>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSubscribersRequest injectToken(
                ListSubscribersRequest payload, String token) {
              return ListSubscribersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSubscribersRequest injectPageSize(
                ListSubscribersRequest payload, int pageSize) {
              return ListSubscribersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSubscribersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSubscribersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subscriber> extractResources(ListSubscribersResponse payload) {
              return payload.getSubscribersList();
            }
          };

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
              return payload.getSubscriptionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSubscribersRequest, ListSubscribersResponse, ListSubscribersPagedResponse>
      LIST_SUBSCRIBERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSubscribersRequest, ListSubscribersResponse, ListSubscribersPagedResponse>() {
            @Override
            public ApiFuture<ListSubscribersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSubscribersRequest, ListSubscribersResponse> callable,
                ListSubscribersRequest request,
                ApiCallContext context,
                ApiFuture<ListSubscribersResponse> futureResponse) {
              PageContext<ListSubscribersRequest, ListSubscribersResponse, Subscriber> pageContext =
                  PageContext.create(callable, LIST_SUBSCRIBERS_PAGE_STR_DESC, request, context);
              return ListSubscribersPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createSubscriber. */
  public UnaryCallSettings<CreateSubscriberRequest, Operation> createSubscriberSettings() {
    return createSubscriberSettings;
  }

  /** Returns the object with the settings used for calls to createSubscriber. */
  public OperationCallSettings<CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
      createSubscriberOperationSettings() {
    return createSubscriberOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSubscribers. */
  public PagedCallSettings<
          ListSubscribersRequest, ListSubscribersResponse, ListSubscribersPagedResponse>
      listSubscribersSettings() {
    return listSubscribersSettings;
  }

  /** Returns the object with the settings used for calls to updateSubscriber. */
  public UnaryCallSettings<UpdateSubscriberRequest, Operation> updateSubscriberSettings() {
    return updateSubscriberSettings;
  }

  /** Returns the object with the settings used for calls to updateSubscriber. */
  public OperationCallSettings<UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
      updateSubscriberOperationSettings() {
    return updateSubscriberOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubscriber. */
  public UnaryCallSettings<DeleteSubscriberRequest, Operation> deleteSubscriberSettings() {
    return deleteSubscriberSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubscriber. */
  public OperationCallSettings<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
      deleteSubscriberOperationSettings() {
    return deleteSubscriberOperationSettings;
  }

  /** Returns the object with the settings used for calls to createSubscription. */
  public UnaryCallSettings<CreateSubscriptionRequest, Subscription> createSubscriptionSettings() {
    return createSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to listSubscriptions. */
  public PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings() {
    return listSubscriptionsSettings;
  }

  /** Returns the object with the settings used for calls to updateSubscription. */
  public UnaryCallSettings<UpdateSubscriptionRequest, Subscription> updateSubscriptionSettings() {
    return updateSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public UnaryCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings() {
    return deleteSubscriptionSettings;
  }

  public DataSubscriptionServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataSubscriptionServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataSubscriptionServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "health";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "health.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "health.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DataSubscriptionServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataSubscriptionServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataSubscriptionServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataSubscriptionServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSubscriberSettings = settingsBuilder.createSubscriberSettings().build();
    createSubscriberOperationSettings = settingsBuilder.createSubscriberOperationSettings().build();
    listSubscribersSettings = settingsBuilder.listSubscribersSettings().build();
    updateSubscriberSettings = settingsBuilder.updateSubscriberSettings().build();
    updateSubscriberOperationSettings = settingsBuilder.updateSubscriberOperationSettings().build();
    deleteSubscriberSettings = settingsBuilder.deleteSubscriberSettings().build();
    deleteSubscriberOperationSettings = settingsBuilder.deleteSubscriberOperationSettings().build();
    createSubscriptionSettings = settingsBuilder.createSubscriptionSettings().build();
    listSubscriptionsSettings = settingsBuilder.listSubscriptionsSettings().build();
    updateSubscriptionSettings = settingsBuilder.updateSubscriptionSettings().build();
    deleteSubscriptionSettings = settingsBuilder.deleteSubscriptionSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-health")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for DataSubscriptionServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DataSubscriptionServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateSubscriberRequest, Operation>
        createSubscriberSettings;
    private final OperationCallSettings.Builder<
            CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
        createSubscriberOperationSettings;
    private final PagedCallSettings.Builder<
            ListSubscribersRequest, ListSubscribersResponse, ListSubscribersPagedResponse>
        listSubscribersSettings;
    private final UnaryCallSettings.Builder<UpdateSubscriberRequest, Operation>
        updateSubscriberSettings;
    private final OperationCallSettings.Builder<
            UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
        updateSubscriberOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSubscriberRequest, Operation>
        deleteSubscriberSettings;
    private final OperationCallSettings.Builder<
            DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
        deleteSubscriberOperationSettings;
    private final UnaryCallSettings.Builder<CreateSubscriptionRequest, Subscription>
        createSubscriptionSettings;
    private final PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings;
    private final UnaryCallSettings.Builder<UpdateSubscriptionRequest, Subscription>
        updateSubscriptionSettings;
    private final UnaryCallSettings.Builder<DeleteSubscriptionRequest, Empty>
        deleteSubscriptionSettings;
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
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createSubscriberSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSubscriberOperationSettings = OperationCallSettings.newBuilder();
      listSubscribersSettings = PagedCallSettings.newBuilder(LIST_SUBSCRIBERS_PAGE_STR_FACT);
      updateSubscriberSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSubscriberOperationSettings = OperationCallSettings.newBuilder();
      deleteSubscriberSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSubscriberOperationSettings = OperationCallSettings.newBuilder();
      createSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSubscriptionsSettings = PagedCallSettings.newBuilder(LIST_SUBSCRIPTIONS_PAGE_STR_FACT);
      updateSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSubscriberSettings,
              listSubscribersSettings,
              updateSubscriberSettings,
              deleteSubscriberSettings,
              createSubscriptionSettings,
              listSubscriptionsSettings,
              updateSubscriptionSettings,
              deleteSubscriptionSettings);
      initDefaults(this);
    }

    protected Builder(DataSubscriptionServiceStubSettings settings) {
      super(settings);

      createSubscriberSettings = settings.createSubscriberSettings.toBuilder();
      createSubscriberOperationSettings = settings.createSubscriberOperationSettings.toBuilder();
      listSubscribersSettings = settings.listSubscribersSettings.toBuilder();
      updateSubscriberSettings = settings.updateSubscriberSettings.toBuilder();
      updateSubscriberOperationSettings = settings.updateSubscriberOperationSettings.toBuilder();
      deleteSubscriberSettings = settings.deleteSubscriberSettings.toBuilder();
      deleteSubscriberOperationSettings = settings.deleteSubscriberOperationSettings.toBuilder();
      createSubscriptionSettings = settings.createSubscriptionSettings.toBuilder();
      listSubscriptionsSettings = settings.listSubscriptionsSettings.toBuilder();
      updateSubscriptionSettings = settings.updateSubscriptionSettings.toBuilder();
      deleteSubscriptionSettings = settings.deleteSubscriptionSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSubscriberSettings,
              listSubscribersSettings,
              updateSubscriberSettings,
              deleteSubscriberSettings,
              createSubscriptionSettings,
              listSubscriptionsSettings,
              updateSubscriptionSettings,
              deleteSubscriptionSettings);
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
          .createSubscriberSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSubscribersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSubscriberSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSubscriberSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSubscriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSubscriberOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSubscriberRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Subscriber.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateSubscriberMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateSubscriberOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSubscriberRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Subscriber.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateSubscriberMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteSubscriberOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSubscriberRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteSubscriberMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to createSubscriber. */
    public UnaryCallSettings.Builder<CreateSubscriberRequest, Operation>
        createSubscriberSettings() {
      return createSubscriberSettings;
    }

    /** Returns the builder for the settings used for calls to createSubscriber. */
    public OperationCallSettings.Builder<
            CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
        createSubscriberOperationSettings() {
      return createSubscriberOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSubscribers. */
    public PagedCallSettings.Builder<
            ListSubscribersRequest, ListSubscribersResponse, ListSubscribersPagedResponse>
        listSubscribersSettings() {
      return listSubscribersSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubscriber. */
    public UnaryCallSettings.Builder<UpdateSubscriberRequest, Operation>
        updateSubscriberSettings() {
      return updateSubscriberSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubscriber. */
    public OperationCallSettings.Builder<
            UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
        updateSubscriberOperationSettings() {
      return updateSubscriberOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubscriber. */
    public UnaryCallSettings.Builder<DeleteSubscriberRequest, Operation>
        deleteSubscriberSettings() {
      return deleteSubscriberSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubscriber. */
    public OperationCallSettings.Builder<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
        deleteSubscriberOperationSettings() {
      return deleteSubscriberOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createSubscription. */
    public UnaryCallSettings.Builder<CreateSubscriptionRequest, Subscription>
        createSubscriptionSettings() {
      return createSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to listSubscriptions. */
    public PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings() {
      return listSubscriptionsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubscription. */
    public UnaryCallSettings.Builder<UpdateSubscriptionRequest, Subscription>
        updateSubscriptionSettings() {
      return updateSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public UnaryCallSettings.Builder<DeleteSubscriptionRequest, Empty>
        deleteSubscriptionSettings() {
      return deleteSubscriptionSettings;
    }

    @Override
    public DataSubscriptionServiceStubSettings build() throws IOException {
      return new DataSubscriptionServiceStubSettings(this);
    }
  }
}
