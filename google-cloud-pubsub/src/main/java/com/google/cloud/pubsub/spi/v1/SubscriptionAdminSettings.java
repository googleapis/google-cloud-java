/*
 * Copyright 2017, Google Inc. All rights reserved.
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
package com.google.cloud.pubsub.spi.v1;

import static com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListSnapshotsPagedResponse;
import static com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.CallContext;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ClientSettings;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.PagedCallSettings;
import com.google.api.gax.grpc.PagedListDescriptor;
import com.google.api.gax.grpc.PagedListResponseFactory;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.api.gax.grpc.StreamingCallSettings;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.IAMPolicyGrpc;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.ExperimentalApi;
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
import com.google.pubsub.v1.SubscriberGrpc;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.UpdateSubscriptionRequest;
import io.grpc.Status;
import java.io.IOException;
import javax.annotation.Generated;
import org.joda.time.Duration;

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
 *     SubscriptionAdminSettings.defaultBuilder();
 * subscriptionAdminSettingsBuilder.createSubscriptionSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * SubscriptionAdminSettings subscriptionAdminSettings = subscriptionAdminSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@ExperimentalApi
public class SubscriptionAdminSettings extends ClientSettings {
  /** The default address of the service. */
  private static final String DEFAULT_SERVICE_ADDRESS = "pubsub.googleapis.com";

  /** The default port of the service. */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/pubsub")
          .build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final SimpleCallSettings<Subscription, Subscription> createSubscriptionSettings;
  private final SimpleCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings;
  private final SimpleCallSettings<UpdateSubscriptionRequest, Subscription>
      updateSubscriptionSettings;
  private final PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings;
  private final SimpleCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings;
  private final SimpleCallSettings<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineSettings;
  private final SimpleCallSettings<AcknowledgeRequest, Empty> acknowledgeSettings;
  private final SimpleCallSettings<PullRequest, PullResponse> pullSettings;
  private final StreamingCallSettings<StreamingPullRequest, StreamingPullResponse>
      streamingPullSettings;
  private final SimpleCallSettings<ModifyPushConfigRequest, Empty> modifyPushConfigSettings;
  private final PagedCallSettings<
          ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings;
  private final SimpleCallSettings<CreateSnapshotRequest, Snapshot> createSnapshotSettings;
  private final SimpleCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotSettings;
  private final SimpleCallSettings<SeekRequest, SeekResponse> seekSettings;
  private final SimpleCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final SimpleCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final SimpleCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  /** Returns the object with the settings used for calls to createSubscription. */
  public SimpleCallSettings<Subscription, Subscription> createSubscriptionSettings() {
    return createSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to getSubscription. */
  public SimpleCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings() {
    return getSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to updateSubscription. */
  public SimpleCallSettings<UpdateSubscriptionRequest, Subscription> updateSubscriptionSettings() {
    return updateSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to listSubscriptions. */
  public PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings() {
    return listSubscriptionsSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public SimpleCallSettings<DeleteSubscriptionRequest, Empty> deleteSubscriptionSettings() {
    return deleteSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to modifyAckDeadline. */
  public SimpleCallSettings<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineSettings() {
    return modifyAckDeadlineSettings;
  }

  /** Returns the object with the settings used for calls to acknowledge. */
  public SimpleCallSettings<AcknowledgeRequest, Empty> acknowledgeSettings() {
    return acknowledgeSettings;
  }

  /** Returns the object with the settings used for calls to pull. */
  public SimpleCallSettings<PullRequest, PullResponse> pullSettings() {
    return pullSettings;
  }

  /** Returns the object with the settings used for calls to streamingPull. */
  public StreamingCallSettings<StreamingPullRequest, StreamingPullResponse>
      streamingPullSettings() {
    return streamingPullSettings;
  }

  /** Returns the object with the settings used for calls to modifyPushConfig. */
  public SimpleCallSettings<ModifyPushConfigRequest, Empty> modifyPushConfigSettings() {
    return modifyPushConfigSettings;
  }

  /** Returns the object with the settings used for calls to listSnapshots. */
  public PagedCallSettings<ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings() {
    return listSnapshotsSettings;
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public SimpleCallSettings<CreateSnapshotRequest, Snapshot> createSnapshotSettings() {
    return createSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to deleteSnapshot. */
  public SimpleCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotSettings() {
    return deleteSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to seek. */
  public SimpleCallSettings<SeekRequest, SeekResponse> seekSettings() {
    return seekSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public SimpleCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public SimpleCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public SimpleCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service address. */
  public static String getDefaultServiceAddress() {
    return DEFAULT_SERVICE_ADDRESS;
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return DEFAULT_SERVICE_PORT;
  }

  /** Returns the default service scopes. */
  public static ImmutableList<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingChannelProvider.Builder defaultChannelProviderBuilder() {
    return InstantiatingChannelProvider.newBuilder()
        .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
        .setPort(DEFAULT_SERVICE_PORT)
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion())
        .setCredentialsProvider(defaultCredentialsProviderBuilder().build());
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

  /** Returns a builder for this class with recommended defaults. */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private SubscriptionAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder.getExecutorProvider(), settingsBuilder.getChannelProvider());

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
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListSubscriptionsRequest injectToken(
                ListSubscriptionsRequest payload, Object token) {
              return ListSubscriptionsRequest.newBuilder(payload)
                  .setPageToken((String) token)
                  .build();
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
            public Object extractNextToken(ListSubscriptionsResponse payload) {
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
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListSnapshotsRequest injectToken(ListSnapshotsRequest payload, Object token) {
              return ListSnapshotsRequest.newBuilder(payload).setPageToken((String) token).build();
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
            public Object extractNextToken(ListSnapshotsResponse payload) {
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
            public ListSubscriptionsPagedResponse createPagedListResponse(
                UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse> callable,
                ListSubscriptionsRequest request,
                CallContext context) {
              return new ListSubscriptionsPagedResponse(
                  callable, LIST_SUBSCRIPTIONS_PAGE_STR_DESC, request, context);
            }
          };

  private static final PagedListResponseFactory<
          ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      LIST_SNAPSHOTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>() {
            @Override
            public ListSnapshotsPagedResponse createPagedListResponse(
                UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> callable,
                ListSnapshotsRequest request,
                CallContext context) {
              return new ListSnapshotsPagedResponse(
                  callable, LIST_SNAPSHOTS_PAGE_STR_DESC, request, context);
            }
          };

  /** Builder for SubscriptionAdminSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder> unaryMethodSettingsBuilders;

    private final SimpleCallSettings.Builder<Subscription, Subscription> createSubscriptionSettings;
    private final SimpleCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings;
    private final SimpleCallSettings.Builder<UpdateSubscriptionRequest, Subscription>
        updateSubscriptionSettings;
    private final PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings;
    private final SimpleCallSettings.Builder<DeleteSubscriptionRequest, Empty>
        deleteSubscriptionSettings;
    private final SimpleCallSettings.Builder<ModifyAckDeadlineRequest, Empty>
        modifyAckDeadlineSettings;
    private final SimpleCallSettings.Builder<AcknowledgeRequest, Empty> acknowledgeSettings;
    private final SimpleCallSettings.Builder<PullRequest, PullResponse> pullSettings;
    private final StreamingCallSettings.Builder<StreamingPullRequest, StreamingPullResponse>
        streamingPullSettings;
    private final SimpleCallSettings.Builder<ModifyPushConfigRequest, Empty>
        modifyPushConfigSettings;
    private final PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings;
    private final SimpleCallSettings.Builder<CreateSnapshotRequest, Snapshot>
        createSnapshotSettings;
    private final SimpleCallSettings.Builder<DeleteSnapshotRequest, Empty> deleteSnapshotSettings;
    private final SimpleCallSettings.Builder<SeekRequest, SeekResponse> seekSettings;
    private final SimpleCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final SimpleCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final SimpleCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put(
          "non_idempotent",
          Sets.immutableEnumSet(Lists.<Status.Code>newArrayList(Status.Code.UNAVAILABLE)));
      definitions.put(
          "pull",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.CANCELLED,
                  Status.Code.DEADLINE_EXCEEDED,
                  Status.Code.RESOURCE_EXHAUSTED,
                  Status.Code.INTERNAL,
                  Status.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings.Builder> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings.Builder> definitions = ImmutableMap.builder();
      RetrySettings.Builder settingsBuilder = null;
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.millis(60000L))
              .setInitialRpcTimeout(Duration.millis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.millis(60000L))
              .setTotalTimeout(Duration.millis(600000L));
      definitions.put("default", settingsBuilder);
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.millis(60000L))
              .setInitialRpcTimeout(Duration.millis(12000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.millis(12000L))
              .setTotalTimeout(Duration.millis(600000L));
      definitions.put("messaging", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(defaultChannelProviderBuilder().build());

      createSubscriptionSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_CREATE_SUBSCRIPTION);

      getSubscriptionSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_GET_SUBSCRIPTION);

      updateSubscriptionSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_UPDATE_SUBSCRIPTION);

      listSubscriptionsSettings =
          PagedCallSettings.newBuilder(
              SubscriberGrpc.METHOD_LIST_SUBSCRIPTIONS, LIST_SUBSCRIPTIONS_PAGE_STR_FACT);

      deleteSubscriptionSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_DELETE_SUBSCRIPTION);

      modifyAckDeadlineSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_MODIFY_ACK_DEADLINE);

      acknowledgeSettings = SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_ACKNOWLEDGE);

      pullSettings = SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_PULL);

      streamingPullSettings =
          StreamingCallSettings.newBuilder(SubscriberGrpc.METHOD_STREAMING_PULL);

      modifyPushConfigSettings =
          SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_MODIFY_PUSH_CONFIG);

      listSnapshotsSettings =
          PagedCallSettings.newBuilder(
              SubscriberGrpc.METHOD_LIST_SNAPSHOTS, LIST_SNAPSHOTS_PAGE_STR_FACT);

      createSnapshotSettings = SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_CREATE_SNAPSHOT);

      deleteSnapshotSettings = SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_DELETE_SNAPSHOT);

      seekSettings = SimpleCallSettings.newBuilder(SubscriberGrpc.METHOD_SEEK);

      setIamPolicySettings = SimpleCallSettings.newBuilder(IAMPolicyGrpc.METHOD_SET_IAM_POLICY);

      getIamPolicySettings = SimpleCallSettings.newBuilder(IAMPolicyGrpc.METHOD_GET_IAM_POLICY);

      testIamPermissionsSettings =
          SimpleCallSettings.newBuilder(IAMPolicyGrpc.METHOD_TEST_IAM_PERMISSIONS);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
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
              deleteSnapshotSettings,
              seekSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .createSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listSubscriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .modifyAckDeadlineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .acknowledgeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("messaging"));

      builder
          .pullSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("pull"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("messaging"));

      builder
          .modifyPushConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listSnapshotsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .seekSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

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
      deleteSnapshotSettings = settings.deleteSnapshotSettings.toBuilder();
      seekSettings = settings.seekSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
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
              deleteSnapshotSettings,
              seekSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    @Override
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setChannelProvider(ChannelProvider channelProvider) {
      super.setChannelProvider(channelProvider);
      return this;
    }

    /**
     * Applies the given settings to all of the unary API methods in this service. Only values that
     * are non-null will be applied, so this method is not capable of un-setting any values.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(UnaryCallSettings.Builder unaryCallSettings)
        throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, unaryCallSettings);
      return this;
    }

    /** Returns the builder for the settings used for calls to createSubscription. */
    public SimpleCallSettings.Builder<Subscription, Subscription> createSubscriptionSettings() {
      return createSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to getSubscription. */
    public SimpleCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings() {
      return getSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubscription. */
    public SimpleCallSettings.Builder<UpdateSubscriptionRequest, Subscription>
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
    public SimpleCallSettings.Builder<DeleteSubscriptionRequest, Empty>
        deleteSubscriptionSettings() {
      return deleteSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to modifyAckDeadline. */
    public SimpleCallSettings.Builder<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineSettings() {
      return modifyAckDeadlineSettings;
    }

    /** Returns the builder for the settings used for calls to acknowledge. */
    public SimpleCallSettings.Builder<AcknowledgeRequest, Empty> acknowledgeSettings() {
      return acknowledgeSettings;
    }

    /** Returns the builder for the settings used for calls to pull. */
    public SimpleCallSettings.Builder<PullRequest, PullResponse> pullSettings() {
      return pullSettings;
    }

    /** Returns the builder for the settings used for calls to streamingPull. */
    public StreamingCallSettings.Builder<StreamingPullRequest, StreamingPullResponse>
        streamingPullSettings() {
      return streamingPullSettings;
    }

    /** Returns the builder for the settings used for calls to modifyPushConfig. */
    public SimpleCallSettings.Builder<ModifyPushConfigRequest, Empty> modifyPushConfigSettings() {
      return modifyPushConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listSnapshots. */
    public PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings() {
      return listSnapshotsSettings;
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public SimpleCallSettings.Builder<CreateSnapshotRequest, Snapshot> createSnapshotSettings() {
      return createSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSnapshot. */
    public SimpleCallSettings.Builder<DeleteSnapshotRequest, Empty> deleteSnapshotSettings() {
      return deleteSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to seek. */
    public SimpleCallSettings.Builder<SeekRequest, SeekResponse> seekSettings() {
      return seekSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public SimpleCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public SimpleCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public SimpleCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public SubscriptionAdminSettings build() throws IOException {
      return new SubscriptionAdminSettings(this);
    }
  }
}
