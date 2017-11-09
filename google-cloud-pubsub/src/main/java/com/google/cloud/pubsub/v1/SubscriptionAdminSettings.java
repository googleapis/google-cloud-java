/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pubsub.v1;

import static com.google.cloud.pubsub.v1.PagedResponseWrappers.ListSnapshotsPagedResponse;
import static com.google.cloud.pubsub.v1.PagedResponseWrappers.ListSubscriptionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.grpc.GrpcExtraHeaderData;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.pubsub.v1.stub.GrpcSubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.CreateSnapshotRequest;
import com.google.pubsub.v1.DeleteSnapshotRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSnapshotsRequest;
import com.google.pubsub.v1.ListSnapshotsResponse;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.SeekRequest;
import com.google.pubsub.v1.SeekResponse;
import com.google.pubsub.v1.Snapshot;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.UpdateSnapshotRequest;
import com.google.pubsub.v1.UpdateSubscriptionRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SubscriptionAdminClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (pubsub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of createSubscription to 30 seconds:
 *
 * <pre>
 * <code>
 * SubscriptionAdminSettings.Builder subscriptionAdminSettingsBuilder =
 *     SubscriptionAdminSettings.newBuilder();
 * subscriptionAdminSettingsBuilder.createSubscriptionSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * SubscriptionAdminSettings subscriptionAdminSettings = subscriptionAdminSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class SubscriptionAdminSettings extends ClientSettings<SubscriptionAdminSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/pubsub")
          .build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/com/google/cloud/pubsub/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final UnaryCallSettings<Subscription, Subscription> createSubscriptionSettings;
  private final UnaryCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings;
  private final UnaryCallSettings<UpdateSubscriptionRequest, Subscription>
      updateSubscriptionSettings;
  private final PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings;
  private final UnaryCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings;
  private final UnaryCallSettings<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineSettings;
  private final UnaryCallSettings<AcknowledgeRequest, Empty> acknowledgeSettings;
  private final UnaryCallSettings<PullRequest, PullResponse> pullSettings;
  private final StreamingCallSettings<StreamingPullRequest, StreamingPullResponse>
      streamingPullSettings;
  private final UnaryCallSettings<ModifyPushConfigRequest, Empty> modifyPushConfigSettings;
  private final PagedCallSettings<
          ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings;
  private final UnaryCallSettings<CreateSnapshotRequest, Snapshot> createSnapshotSettings;
  private final UnaryCallSettings<UpdateSnapshotRequest, Snapshot> updateSnapshotSettings;
  private final UnaryCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotSettings;
  private final UnaryCallSettings<SeekRequest, SeekResponse> seekSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  /** Returns the object with the settings used for calls to createSubscription. */
  public UnaryCallSettings<Subscription, Subscription> createSubscriptionSettings() {
    return createSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to getSubscription. */
  public UnaryCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings() {
    return getSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to updateSubscription. */
  public UnaryCallSettings<UpdateSubscriptionRequest, Subscription> updateSubscriptionSettings() {
    return updateSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to listSubscriptions. */
  public PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings() {
    return listSubscriptionsSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public UnaryCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings() {
    return deleteSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to modifyAckDeadline. */
  public UnaryCallSettings<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineSettings() {
    return modifyAckDeadlineSettings;
  }

  /** Returns the object with the settings used for calls to acknowledge. */
  public UnaryCallSettings<AcknowledgeRequest, Empty> acknowledgeSettings() {
    return acknowledgeSettings;
  }

  /** Returns the object with the settings used for calls to pull. */
  public UnaryCallSettings<PullRequest, PullResponse> pullSettings() {
    return pullSettings;
  }

  /** Returns the object with the settings used for calls to streamingPull. */
  public StreamingCallSettings<StreamingPullRequest, StreamingPullResponse>
      streamingPullSettings() {
    return streamingPullSettings;
  }

  /** Returns the object with the settings used for calls to modifyPushConfig. */
  public UnaryCallSettings<ModifyPushConfigRequest, Empty> modifyPushConfigSettings() {
    return modifyPushConfigSettings;
  }

  /** Returns the object with the settings used for calls to listSnapshots. */
  public PagedCallSettings<ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings() {
    return listSnapshotsSettings;
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public UnaryCallSettings<CreateSnapshotRequest, Snapshot> createSnapshotSettings() {
    return createSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to updateSnapshot. */
  public UnaryCallSettings<UpdateSnapshotRequest, Snapshot> updateSnapshotSettings() {
    return updateSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to deleteSnapshot. */
  public UnaryCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotSettings() {
    return deleteSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to seek. */
  public UnaryCallSettings<SeekRequest, SeekResponse> seekSettings() {
    return seekSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SubscriberStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSubscriberStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "pubsub.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion())
        .setApiClientHeaderLineKey("x-goog-api-client")
        .addApiClientHeaderLineData(GrpcExtraHeaderData.getXGoogApiClientData());
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion =
          PropertiesProvider.loadProperty(
              SubscriptionAdminSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
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

  private SubscriptionAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSubscriptionSettings = settingsBuilder.createSubscriptionSettings().build();
    getSubscriptionSettings = settingsBuilder.getSubscriptionSettings().build();
    updateSubscriptionSettings = settingsBuilder.updateSubscriptionSettings().build();
    listSubscriptionsSettings = settingsBuilder.listSubscriptionsSettings().build();
    deleteSubscriptionSettings = settingsBuilder.deleteSubscriptionSettings().build();
    modifyAckDeadlineSettings = settingsBuilder.modifyAckDeadlineSettings().build();
    acknowledgeSettings = settingsBuilder.acknowledgeSettings().build();
    pullSettings = settingsBuilder.pullSettings().build();
    streamingPullSettings = settingsBuilder.streamingPullSettings().build();
    modifyPushConfigSettings = settingsBuilder.modifyPushConfigSettings().build();
    listSnapshotsSettings = settingsBuilder.listSnapshotsSettings().build();
    createSnapshotSettings = settingsBuilder.createSnapshotSettings().build();
    updateSnapshotSettings = settingsBuilder.updateSnapshotSettings().build();
    deleteSnapshotSettings = settingsBuilder.deleteSnapshotSettings().build();
    seekSettings = settingsBuilder.seekSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

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

  private static final PagedListDescriptor<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot>
      LIST_SNAPSHOTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSnapshotsRequest injectToken(ListSnapshotsRequest payload, String token) {
              return ListSnapshotsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSnapshotsRequest injectPageSize(ListSnapshotsRequest payload, int pageSize) {
              return ListSnapshotsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSnapshotsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSnapshotsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Snapshot> extractResources(ListSnapshotsResponse payload) {
              return payload.getSnapshotsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      LIST_SUBSCRIPTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSubscriptionsRequest, ListSubscriptionsResponse,
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

  private static final PagedListResponseFactory<
          ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      LIST_SNAPSHOTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>() {
            @Override
            public ApiFuture<ListSnapshotsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> callable,
                ListSnapshotsRequest request,
                ApiCallContext context,
                ApiFuture<ListSnapshotsResponse> futureResponse) {
              PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> pageContext =
                  PageContext.create(callable, LIST_SNAPSHOTS_PAGE_STR_DESC, request, context);
              return ListSnapshotsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for SubscriptionAdminSettings. */
  public static class Builder extends ClientSettings.Builder<SubscriptionAdminSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<Subscription, Subscription> createSubscriptionSettings;
    private final UnaryCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings;
    private final UnaryCallSettings.Builder<UpdateSubscriptionRequest, Subscription>
        updateSubscriptionSettings;
    private final PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings;
    private final UnaryCallSettings.Builder<DeleteSubscriptionRequest, Empty>
        deleteSubscriptionSettings;
    private final UnaryCallSettings.Builder<ModifyAckDeadlineRequest, Empty>
        modifyAckDeadlineSettings;
    private final UnaryCallSettings.Builder<AcknowledgeRequest, Empty> acknowledgeSettings;
    private final UnaryCallSettings.Builder<PullRequest, PullResponse> pullSettings;
    private final StreamingCallSettings.Builder<StreamingPullRequest, StreamingPullResponse>
        streamingPullSettings;
    private final UnaryCallSettings.Builder<ModifyPushConfigRequest, Empty>
        modifyPushConfigSettings;
    private final PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings;
    private final UnaryCallSettings.Builder<CreateSnapshotRequest, Snapshot> createSnapshotSettings;
    private final UnaryCallSettings.Builder<UpdateSnapshotRequest, Snapshot> updateSnapshotSettings;
    private final UnaryCallSettings.Builder<DeleteSnapshotRequest, Empty> deleteSnapshotSettings;
    private final UnaryCallSettings.Builder<SeekRequest, SeekResponse> seekSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "pull",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.CANCELLED,
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.RESOURCE_EXHAUSTED,
                  StatusCode.Code.UNAVAILABLE)));
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
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(12000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(12000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("messaging", settings);
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
      definitions.put("streaming_messaging", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      this((ClientContext) null);
    }

    private Builder(ClientContext clientContext) {
      super(clientContext);

      createSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listSubscriptionsSettings = PagedCallSettings.newBuilder(LIST_SUBSCRIPTIONS_PAGE_STR_FACT);

      deleteSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      modifyAckDeadlineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      acknowledgeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      pullSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      streamingPullSettings = StreamingCallSettings.newBuilder();

      modifyPushConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listSnapshotsSettings = PagedCallSettings.newBuilder(LIST_SNAPSHOTS_PAGE_STR_FACT);

      createSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      seekSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSubscriptionSettings,
              getSubscriptionSettings,
              updateSubscriptionSettings,
              listSubscriptionsSettings,
              deleteSubscriptionSettings,
              modifyAckDeadlineSettings,
              acknowledgeSettings,
              pullSettings,
              modifyPushConfigSettings,
              listSnapshotsSettings,
              createSnapshotSettings,
              updateSnapshotSettings,
              deleteSnapshotSettings,
              seekSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .createSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listSubscriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .modifyAckDeadlineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .acknowledgeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("messaging"));

      builder
          .pullSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("pull"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("messaging"));

      builder
          .modifyPushConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listSnapshotsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .seekSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(SubscriptionAdminSettings settings) {
      super(settings);

      createSubscriptionSettings = settings.createSubscriptionSettings.toBuilder();
      getSubscriptionSettings = settings.getSubscriptionSettings.toBuilder();
      updateSubscriptionSettings = settings.updateSubscriptionSettings.toBuilder();
      listSubscriptionsSettings = settings.listSubscriptionsSettings.toBuilder();
      deleteSubscriptionSettings = settings.deleteSubscriptionSettings.toBuilder();
      modifyAckDeadlineSettings = settings.modifyAckDeadlineSettings.toBuilder();
      acknowledgeSettings = settings.acknowledgeSettings.toBuilder();
      pullSettings = settings.pullSettings.toBuilder();
      streamingPullSettings = settings.streamingPullSettings.toBuilder();
      modifyPushConfigSettings = settings.modifyPushConfigSettings.toBuilder();
      listSnapshotsSettings = settings.listSnapshotsSettings.toBuilder();
      createSnapshotSettings = settings.createSnapshotSettings.toBuilder();
      updateSnapshotSettings = settings.updateSnapshotSettings.toBuilder();
      deleteSnapshotSettings = settings.deleteSnapshotSettings.toBuilder();
      seekSettings = settings.seekSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSubscriptionSettings,
              getSubscriptionSettings,
              updateSubscriptionSettings,
              listSubscriptionsSettings,
              deleteSubscriptionSettings,
              modifyAckDeadlineSettings,
              acknowledgeSettings,
              pullSettings,
              modifyPushConfigSettings,
              listSnapshotsSettings,
              createSnapshotSettings,
              updateSnapshotSettings,
              deleteSnapshotSettings,
              seekSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

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

    /** Returns the builder for the settings used for calls to createSubscription. */
    public UnaryCallSettings.Builder<Subscription, Subscription> createSubscriptionSettings() {
      return createSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to getSubscription. */
    public UnaryCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings() {
      return getSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubscription. */
    public UnaryCallSettings.Builder<UpdateSubscriptionRequest, Subscription>
        updateSubscriptionSettings() {
      return updateSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to listSubscriptions. */
    public PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings() {
      return listSubscriptionsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public UnaryCallSettings.Builder<DeleteSubscriptionRequest, Empty>
        deleteSubscriptionSettings() {
      return deleteSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to modifyAckDeadline. */
    public UnaryCallSettings.Builder<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineSettings() {
      return modifyAckDeadlineSettings;
    }

    /** Returns the builder for the settings used for calls to acknowledge. */
    public UnaryCallSettings.Builder<AcknowledgeRequest, Empty> acknowledgeSettings() {
      return acknowledgeSettings;
    }

    /** Returns the builder for the settings used for calls to pull. */
    public UnaryCallSettings.Builder<PullRequest, PullResponse> pullSettings() {
      return pullSettings;
    }

    /** Returns the builder for the settings used for calls to streamingPull. */
    public StreamingCallSettings.Builder<StreamingPullRequest, StreamingPullResponse>
        streamingPullSettings() {
      return streamingPullSettings;
    }

    /** Returns the builder for the settings used for calls to modifyPushConfig. */
    public UnaryCallSettings.Builder<ModifyPushConfigRequest, Empty> modifyPushConfigSettings() {
      return modifyPushConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listSnapshots. */
    public PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings() {
      return listSnapshotsSettings;
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public UnaryCallSettings.Builder<CreateSnapshotRequest, Snapshot> createSnapshotSettings() {
      return createSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to updateSnapshot. */
    public UnaryCallSettings.Builder<UpdateSnapshotRequest, Snapshot> updateSnapshotSettings() {
      return updateSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSnapshot. */
    public UnaryCallSettings.Builder<DeleteSnapshotRequest, Empty> deleteSnapshotSettings() {
      return deleteSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to seek. */
    public UnaryCallSettings.Builder<SeekRequest, SeekResponse> seekSettings() {
      return seekSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public SubscriptionAdminSettings build() throws IOException {
      return new SubscriptionAdminSettings(this);
    }
  }
}
